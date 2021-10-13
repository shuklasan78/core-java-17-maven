package log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lombok {

    public static void main(String[] args) {
        log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
    }
}
