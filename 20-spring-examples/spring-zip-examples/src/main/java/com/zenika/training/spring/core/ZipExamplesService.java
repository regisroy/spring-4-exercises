package com.zenika.training.spring.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExamplesService {

    public void zip() throws IOException {
        //copier la source
        Path source = new File("../..").toPath();
        Files.copy(Paths.get("../../20-spring-examples"), Paths.get("../../copy_temporaire_20-spring-examples"));

        //lister les projets et les répertoires à zipper et supprimer les autres
        //Supprimer tous les répertoires target


        //créer le zip

        //déplacer le zip dans le projet spring-boot-file-server

    }

}
