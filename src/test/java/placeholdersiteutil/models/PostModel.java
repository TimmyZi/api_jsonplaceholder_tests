package placeholdersiteutil.models;

public class PostModel {

    private Integer userId;
    private String title;
    private String body;
    private Integer id;

    public PostModel() {
    }

    public PostModel(Integer userId, String title, String body, Integer id) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public PostModel(Integer userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
