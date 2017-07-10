import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import java.util.HashMap;

public abstract class AppRoute implements TemplateViewRoute {
    private String mLayout;
    protected HashMap<String, Object> model;

    public AppRoute(String template, String layout) {
        model = new HashMap<>();
        model.put("template", template);
        mLayout = layout;
    }

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        createModel(request, response);
        return new ModelAndView(model, mLayout);
    }

    protected abstract void createModel(Request request, Response response);
}
