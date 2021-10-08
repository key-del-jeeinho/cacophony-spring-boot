import org.junit.jupiter.api.Test;

public class CacophonySpecification {
    @Test
    public void specification001() {
        doSomething(
                event -> System.out.println(event);
        ).when(
                onChat()
                .and().onJoin()
        ).complete();
    }
}
