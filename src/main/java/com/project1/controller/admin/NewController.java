package com.project1.controller.admin;


import com.project1.constant.SystemConstant;
import com.project1.model.NewModel;
import com.project1.paging.PageRequest;
import com.project1.paging.Pageble;
import com.project1.service.ICategoryService;
import com.project1.service.ICelebrityService;
import com.project1.service.INewService;
import com.project1.sort.Sorter;
import com.project1.utils.FormUtil;
import com.project1.utils.MessageUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

    private static final long serialVersionUID = 2686801510274002166L;

    @Inject
    private INewService newService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private ICelebrityService celebrityService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        NewModel model = FormUtil.toModel(NewModel.class, request);
        String view ="";
        if (model.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                    new Sorter(model.getSortName(),model.getSortBy()));
            model.setListResult(newService.findAll(pageble));
            model.setTotalItem(newService.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem()/model.getMaxPageItem()));
            view = "/views/admin/new/list.jsp";
        } else if (model.getType().equals(SystemConstant.EDIT)) {
            if (model.getId() != null) {
                model = newService.findOne(model.getId());
            }
            request.setAttribute("categories", categoryService.findAll());
            request.setAttribute("celebrities", celebrityService.findAll());
            view = "/views/admin/new/edit.jsp";
        }
        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }
}
