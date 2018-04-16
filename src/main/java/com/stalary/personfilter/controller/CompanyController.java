package com.stalary.personfilter.controller;

import com.stalary.personfilter.data.dto.ResponseMessage;
import com.stalary.personfilter.data.entity.mysql.Company;
import com.stalary.personfilter.service.mysql.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CompanyController
 *
 * @author lirongqian
 * @since 2018/04/14
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 查找所有公司，分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查找所有公司", notes = "分页，一页4个")
    public ResponseMessage allCompany(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "4") int size) {
        return ResponseMessage.successMessage(companyService.allCompany(page, size));
    }

    /**
     * 添加公司
     * @param company
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加公司", notes = "传入公司对象")
    public ResponseMessage addCompany(
            @RequestBody Company company) {
        return ResponseMessage.successMessage(companyService.save(company));
    }
}