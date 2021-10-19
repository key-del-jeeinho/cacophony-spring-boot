package io.github.key_del_jeeinho.cacophony_lib.global.exception;

/**
 * 봇을 위한 JDA 클라이언트 생성에 실패할 경우 발생하는 예외입니다.
 * 예를들어, Property 의 토큰이 올바르지 않아 봇 생성에 실패할 경우 발생합니다
 *
 * @author JeeInho
 * @since 0.0.1-SNAPSHOT
 */
public class BotCreationFailureException extends RuntimeException {
    public BotCreationFailureException(Throwable e) {
        super(e);
    }
}
