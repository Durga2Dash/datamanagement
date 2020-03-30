package com.employee.management.datamanagement.api;

import com.employee.management.datamanagement.exception.RecordNotFoundException;
import com.employee.management.datamanagement.model.EmployeeEntity;
import com.employee.management.datamanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class EmployeeDataController {
    @Autowired
    EmployeeService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
        return list;
    }

    @RequestMapping(path = {"/edit/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        System.out.println("[getEmployeeById] id : "+id);
        EmployeeEntity entity = service.getEmployeeById(id);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        System.out.println("[deleteEmployeeById] id : "+id);
        service.deleteEmployeeById(id);
        return ResponseEntity.ok("Record deleted successfully!!!");
    }

    @RequestMapping(path = "/create-update", method = RequestMethod.POST)
    public ResponseEntity<String> createOrUpdateEmployee(@RequestBody EmployeeEntity employee) {
        System.out.println("[createOrUpdateEmployee] employee : "+employee);
        service.createOrUpdateEmployee(employee);
        return ResponseEntity.ok("Record created/updated successfully!!!");
    }
}
