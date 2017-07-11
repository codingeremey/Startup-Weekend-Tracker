package com.epicodus.java.StartupWeekendTracker.routes;

import com.epicodus.java.StartupWeekendTracker.data.Database;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import java.util.HashMap;

public abstract class AppRoute implements TemplateViewRoute {
    private String mLayout;
    protected HashMap<String, Object> mModel;
    protected Database mDatabase;

    public AppRoute(String template, String layout, Database database) {
        mModel = new HashMap<>();
        mModel.put("template", template);
        mLayout = layout;
        mDatabase = database;
    }

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {
        createModel(request, response);
        return new ModelAndView(mModel, mLayout);
    }

    protected abstract void createModel(Request request, Response response);
}
