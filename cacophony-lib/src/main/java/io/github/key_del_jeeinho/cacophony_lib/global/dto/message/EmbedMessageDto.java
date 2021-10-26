package io.github.key_del_jeeinho.cacophony_lib.global.dto.message;

import io.github.key_del_jeeinho.cacophony_lib.global.dto.DiscordData;
import lombok.Getter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 디스코드 에서 유저가 보낸 메세지에 대한 정보를 저장하는 Dto 입니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */

@Getter
public class EmbedMessageDto extends DiscordData {
     private final TitleDto title;
     private final String description;
     private final Color color;
     private final AuthorDto author;
     private final FooterDto footer;
     private final java.util.List<SectionDto> sections;
     private final List<String> emojis;

    public EmbedMessageDto(
            long id,
            TitleDto title,
            String description,
            Color color,
            AuthorDto author,
            FooterDto footer) {
        super(id);
        this.title = title;
        this.description = description;
        this.color = color;
        this.sections = new ArrayList<>();
        this.author = author;
        this.footer = footer;
        this.emojis = new ArrayList<>();
    }

    public void addSection(SectionDto section) {
        sections.add(section);
    }

    public void addSections(SectionDto... section) {
        sections.addAll(Arrays.asList(section));
    }

    public void addEmoji(String emoji) {
        emojis.add(emoji);
    }

    public MessageEmbed toEmbed() {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle(title.getTitle(), title.getUrl())
                .setDescription(description)
                .setColor(color)
                .setAuthor(author.getName(), author.getUrl(), author.getIconUrl())
                .setFooter(footer.getText(), footer.getIconUrl());

        sections.forEach(section -> builder.addField(section.getTitle(), section.getText(), section.getInline()));

        return builder.build();
    }
}
