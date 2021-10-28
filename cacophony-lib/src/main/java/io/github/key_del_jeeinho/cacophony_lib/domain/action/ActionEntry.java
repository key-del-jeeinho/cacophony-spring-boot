package io.github.key_del_jeeinho.cacophony_lib.domain.action;

import io.github.key_del_jeeinho.cacophony_lib.global.annotation.EntryPoint;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.message.EmbedMessageDto;
import io.github.key_del_jeeinho.cacophony_lib.global.dto.RoleDto;

public class ActionEntry {
    @EntryPoint
    public static void chat(String message, long channelId) {
        ActionGenerator.generateDefault().chat(message, channelId);
    }

    @EntryPoint
    public static void chat(EmbedMessageDto embedMessage, long channelId) {
        ActionGenerator.generateDefault().chat(embedMessage, channelId);
    }

    @EntryPoint
    public static void react(String emote, long messageId, long channelId) {
        ActionGenerator.generateDefault().react(emote, messageId, channelId);
    }

    @EntryPoint
    public static void ban(long userId, long serverId) {
        ActionGenerator.generateDefault().ban(userId, serverId);
    }

    @EntryPoint
    public static void grantRole(long roleId, long userId, long serverId) {
        ActionGenerator.generateDefault().grantRole(roleId, userId, serverId);
    }

    @EntryPoint
    public static void createRole(RoleDto role, long serverId) {
        ActionGenerator.generateDefault().createRole(role, serverId);
    }
}