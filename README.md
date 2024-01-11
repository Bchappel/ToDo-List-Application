# ToDo List Application

Created by Braedan Chappel of the University of Guelph

## Table of Contents
1. Introduction
2. Running the program

## Introduction

This project I made is a command line based ToDo list software, it offers functionality like viewing, adding, completeing, deleting, and saving/loading to and from files.


## Running

Here are the versions of Gradle and Java that are used for this project, I'm not entirely sure back/forward compatibility with other versions but they will probably work.

    Gradle: 
        ------------------------------------------------------------
        Gradle 8.1.1
        ------------------------------------------------------------

        Build time:   2023-04-21 12:31:26 UTC
        Revision:     1cf537a851c635c364a4214885f8b9798051175b

        Kotlin:       1.8.10
        Groovy:       3.0.15
        Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
        JVM:          17.0.7 (Private Build 17.0.7+7-Ubuntu-0ubuntu120.04)
        OS:           Linux 5.15.133.1-microsoft-standard-WSL2 amd64

    Java:
        openjdk 17.0.7 2023-04-18
        OpenJDK Runtime Environment (build 17.0.7+7-Ubuntu-0ubuntu120.04)
        OpenJDK 64-Bit Server VM (build 17.0.7+7-Ubuntu-0ubuntu120.04, mixed mode, sharing)

Running the program can be done multiple ways:

This assumes you have Gradle and Java installed

Method #1: Class Path

Ensure working directory is in the root project folder: /ToDo-List-Application
Type 'gradle build' to start the build process
Once build completes successfully, Enter this command 'java -cp build/classes/java/main ui.TextUI'

Method #2: Jar file

Ensure working directory is in the root project folder: /ToDo-List-Application
Enter this command: 'java -jar build/libs/TODO.jar'





