package pl.opms.fe.controller.testdefinition;

import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.opms.be.entity.QTestDefinitionEntity;
import pl.opms.be.entity.TestDefinitionEntity;
import pl.opms.be.service.TestDefinitionService;

import javax.annotation.PostConstruct;

/**
 * Created by Piotr Borczyk on 11.12.2016.
 */

@Controller
@RequestMapping(value = "/test-definition/crud")
public class TestDefinitionCrudController {

    @Autowired
    private TestDefinitionService testDefinitionService;

    private Pageable pageable;
    private Page<TestDefinitionEntity> page;
    private Predicate predicate;

    @Getter
    @Setter
    public static class SearchBean {
        String searchTerm = "";
        Boolean isDeprecated = false;
    }

    SearchBean searchBean = new SearchBean();

    @PostConstruct
    public void init() {
        QTestDefinitionEntity qTestDefinitionEntity = QTestDefinitionEntity.testDefinitionEntity;
        predicate = qTestDefinitionEntity.name.contains("").and(qTestDefinitionEntity.deprecated.isNotNull());
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView crud(@RequestParam(required = false, defaultValue = "0") Integer pageNumber,
                             @RequestParam(required = false, defaultValue = "15") Integer size) {
        pageable = new PageRequest(pageNumber, size);
        page = testDefinitionService.requestPage(predicate,pageable);
        ModelAndView modelView = new ModelAndView("/test-definition/crud");
        modelView.addObject("totalPages",page.getTotalPages());
        modelView.addObject("testDefinitions",page.getContent());
        modelView.addObject("pageable",pageable);
        modelView.addObject("searchBean",searchBean);
        return modelView;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute SearchBean searchBean) {
        QTestDefinitionEntity qTestDefinitionEntity = QTestDefinitionEntity.testDefinitionEntity;
        predicate = qTestDefinitionEntity.name.contains(searchBean.getSearchTerm())
                .and(qTestDefinitionEntity.deprecated.eq(searchBean.getIsDeprecated()));
        ModelAndView modelAndView = new ModelAndView("redirect:/test-definition/crud");
        return modelAndView;
    }


}
