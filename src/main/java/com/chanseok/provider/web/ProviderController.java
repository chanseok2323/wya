package com.chanseok.provider.web;

import com.chanseok.provider.dto.ProviderDto;
import com.chanseok.provider.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/providers")
public class ProviderController {

    private ProviderService providerService;

    @GetMapping
    public String list(Model model) {
        System.out.println("ProviderController.list");
        List<ProviderDto> providers = providerService.findProviders();
        model.addAttribute("providers", providers);
        return "providers/list";
    }
}
