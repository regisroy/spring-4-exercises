package com.zenika.training.spring.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Controller
public class ExercicesController {

    @RequestMapping("/list")
    public String listFiles(Model model) throws IOException {
        final List<String> files = new ArrayList<>();
        Stream<Path> list = Files.list(new File("src/main/resources/static/zip").toPath());
        list.forEach(new Consumer<Path>() {
            @Override
            public void accept(Path path) {
                files.add(path.getFileName().toString());
            }
        });

        model.addAttribute("files", files);

        System.out.println("\nExercicesController.listFiles\n" + files);

        return "list";
    }

}
