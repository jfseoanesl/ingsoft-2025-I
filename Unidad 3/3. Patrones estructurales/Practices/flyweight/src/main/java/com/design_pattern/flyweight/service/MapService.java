package com.design_pattern.flyweight.service;

import com.design_pattern.flyweight.model.Tree;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MapService {

    private final List<Tree> trees = new ArrayList<>();
    private final Random random = new Random();

    public List<Tree> populateMap() {

       double totalSize=0;
        for (int i = 0; i < 10000; i++) {
            String type = random.nextBoolean() ? "Oak" : "Pine";
            String texture = type.equals("Oak") ? "oak-texture.png" : "pine-texture.png";
            String color = type.equals("Oak") ? "Green" : "Dark Green";
            double height = type.equals("Oak") ? 12 : 8;
            double size = type.equals("Oak") ? 500 : 1000;

            int x = random.nextInt(1000);
            int y = random.nextInt(1000);

            totalSize+=size;

            Tree tree = new Tree(type, texture, color, height, x, y, size);
            trees.add(tree);
        }

        return trees;
    }
}
