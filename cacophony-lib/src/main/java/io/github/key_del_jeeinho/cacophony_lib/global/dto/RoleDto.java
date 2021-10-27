package io.github.key_del_jeeinho.cacophony_lib.global.dto;

import lombok.Getter;
import net.dv8tion.jda.api.Permission;

import java.awt.*;
import java.util.List;

@Getter
public class RoleDto extends DiscordData {
    public RoleDto(long id, String name, Color color, List<Permission> permissions) {
        super(id);
        this.name = name;
        this.color = color;
        this.permissions = permissions;
    }

    public RoleDto(String name, Color color, List<Permission> permissions) {
        this(-1, name, color, permissions);
    }

    public RoleDto(String name, Color color, Permission... permissions) {
        this(-1, name, color, List.of(permissions));
    }

    private final String name;
    private final Color color;
    private final List<Permission> permissions;
}
