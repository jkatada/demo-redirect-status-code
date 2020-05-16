package com.example.demo.redirect;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectDemoController {

    @Autowired
    ServletContext context;

    @ModelAttribute
    public UserBean setUpUserBean() {
        return new UserBean();
    }

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    /*
     * redirect prefix
     */
    @PostMapping("/redirect1")
    public String redirect1(UserBean user, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return "redirect:/result";
    }

    @PostMapping("/redirect2")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public String redirect2(UserBean user) {
        return "redirect:/result";
    }

    @PostMapping("/redirect3")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public String redirect3(UserBean user, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.NOT_ACCEPTABLE);
        return "redirect:/result";
    }

    /*
     * RedirectView
     */
    @PostMapping("/redirectview1")
    public View redirectTestView1(UserBean user) {
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        view.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        return view;
    }

    @PostMapping("/redirectview2")
    public View redirectTestView2(UserBean user, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        return view;
    }

    @PostMapping("/redirectview3")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public View redirectTestView3(UserBean user) {
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        return view;
    }

    @PostMapping("/redirectview4")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public View redirectTestView4(UserBean user, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.NOT_IMPLEMENTED);
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        view.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        return view;
    }

    /*
     * ModelAndView + redirect prefix
     */
    // not work
    @PostMapping("/modelandviewredirect1")
    public ModelAndView modelandviewredirect1(UserBean user, HttpServletRequest request) {
        return new ModelAndView("redirect:/result", HttpStatus.TEMPORARY_REDIRECT);
    }

    @PostMapping("/modelandviewredirect2")
    public ModelAndView modelandviewredirect2(UserBean user, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:/result");
    }

    @PostMapping("/modelandviewredirect3")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public ModelAndView modelandviewredirect3(UserBean user, HttpServletRequest request) {
        return new ModelAndView("redirect:/result");
    }

    /*
     * ModelAndView + RedirectView
     */
    @PostMapping("/modelandviewredirectview1")
    public ModelAndView modelandviewredirectview1(UserBean user, HttpServletRequest request) {
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        view.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView(view);
    }

    @PostMapping("/modelandviewredirectview2")
    public ModelAndView modelandviewredirectview2(UserBean user, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        return new ModelAndView(view);
    }

    @PostMapping("/modelandviewredirectview3")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public ModelAndView modelandviewredirectview3(UserBean user, HttpServletRequest request) {
        RedirectView view = new RedirectView(context.getContextPath() + "/result");
        return new ModelAndView(view);
    }

    /*
     * InternalResourceView (not redirect)
     */
    // not work
    @PostMapping("/jsp1")
    public String jsp1(UserBean user, Model model, HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        model.addAttribute("method", "post");
        model.addAttribute("user", user);
        return "result";
    }

    @PostMapping("/jsp2")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public String jsp2(UserBean user, Model model) {
        model.addAttribute("method", "post");
        model.addAttribute("user", user);
        return "result";
    }

    /*
     * result
     */
    @GetMapping("/result")
    public String getResult(UserBean user, Model model) {
        System.out.println("RedirectDemoController.getResult()");
        System.out.println(user);
        model.addAttribute("method", "get");
        model.addAttribute("user", user);
        return "result";
    }

    @PostMapping("/result")
    public String postResult(UserBean user, Model model) {
        System.out.println("RedirectDemoController.postResult()");
        System.out.println(user);
        model.addAttribute("method", "post");
        model.addAttribute("user", user);
        return "result";
    }
}