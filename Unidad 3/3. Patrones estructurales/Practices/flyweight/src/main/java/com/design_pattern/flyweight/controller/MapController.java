package com.design_pattern.flyweight.controller;

import com.design_pattern.flyweight.model.Tree;
import com.design_pattern.flyweight.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/populate")
    public Map<String, String> populate() {

        List<Tree> trees=mapService.populateMap();
        Map<String, String> response=new HashMap<>();
        double size=0;
        for(Tree tree:trees) {
            size+=tree.getSize();
        }
        response.put("Total trees: ",""+ trees.size());
        response.put("Total size: ","" + size);
        return response;

    }
}
