package baseball;

public enum Texts {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    GAME_TYPE_INPUT("게임 유형을 입력해주세요 : "),
    GAME_SIZE_INPUT("게임 크기를 입력해주세요 : "),
    NUMBER_GAME_START("숫자 야구 게임을 시작합니다."),
    ALPHABET_GAME_START("알파벳 야구 게임을 시작합니다."),
    NUMBER_INPUT("숫자를 입력해주세요 : "),
    ALPHABET_INPUT("알파벳을 입력해주세요 : "),
    NUMBER_CORRECT_ANSWER("개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ALPHABET_CORRECT_ANSWER("개의 알파벳을 모두 맞히셨습니다! 게임 종료"),
    RESULT_INSTRUCTION("게임 결과"),
    RESULT_HEAD_CORRECT_ANSWER("<정답>"),
    RESULT_HEAD_PITCHING_NUMBER("<던진 횟수>"),
    RESULT_HEAD_PITCHING_RECORDS("<게임 내용>"),
    RESTART(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Buttons.GAME_REPEAT.getButton(), Buttons.GAME_END.getButton())),
    GIVE_UP("게임을 포기하셨습니다."),
    MARK_GIVE_UP("!"),
    NONE("없음"),
    ERROR_GAME_TYPE_INPUT("올바른 게임 유형 입력이 아닙니다."),
    ERROR_GAME_SIZE_INPUT("올바른 게임 크기 입력이 아닙니다."),
    ERROR_GAME_GUESS_INPUT("올바른 입력이 아닙니다."),
    ERROR_GAME_END_INPUT("올바른 종료 입력이 아닙니다."),
    ;

    private final String text;

    Texts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
