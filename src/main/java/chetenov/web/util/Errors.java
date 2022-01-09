package chetenov.web.util;

public enum Errors {
    saveError("Ошибка сохранения пользователя. Проверьте данные."),
    err1("Some error 1"),
    err2("Some error 2"),
    err3("Some error 3"),
    err4("Some error 4");
    private String message;

    Errors(String message) {
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
}
