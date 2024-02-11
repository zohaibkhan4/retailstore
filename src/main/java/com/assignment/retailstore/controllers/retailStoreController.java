package com.assignment.retailstore.controllers;

import com.assignment.retailstore.DAO.requests.OrderPlaceRequest;
import com.assignment.retailstore.entities.Employee;
import com.assignment.retailstore.entities.RefCdGrps;
import com.assignment.retailstore.entities.RefCdVals;
import com.assignment.retailstore.entities.Stores;
import com.assignment.retailstore.service.RetailStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class retailStoreController {

    @Autowired
    RetailStoreService storesService;

    @GetMapping("test")
    public String checkApplication() {
        return "Running";
    }

    @GetMapping("refCdGrp/getAll")
    public Iterable<RefCdGrps> getAllGroups() {
        return storesService.getAllRefGroups();
    }

    @GetMapping("refCdVal/getAll")
    public Iterable<RefCdVals> getAllValues() {
        return storesService.getAllRefValues();
    }

    @GetMapping(path = "store/getAll")
    public @ResponseBody Iterable<Stores> getAllStores() {
        return storesService.getAllStores();
    }

    @GetMapping(path = "employee/getAll")
    public @ResponseBody Iterable<Employee> getAllEmployee() {
        return storesService.getAllEmployee();
    }

    @PostMapping("store/add")
    public String addNewStore(@RequestBody Stores stores) {
        return "";
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<Stores> get(@PathVariable("id") int id) {
        // Custom logic
        return ResponseEntity.ok(new Stores());
    }

    @PostMapping("order/place")
    public ResponseEntity<String> placeNewOrder(@RequestBody OrderPlaceRequest orderPlaceRequest){
        String response = "";
        if( orderPlaceRequest == null ){
            response = "Invalid request data";
        }else{
            response = storesService.placeNewOrder(orderPlaceRequest);
        }
        return ResponseEntity.ok(response);
    }
}
