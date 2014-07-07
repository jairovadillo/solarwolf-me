# SolarWolf

Spaceship survival game for Java mobiles based on: [SolarWolf python edition](#) and [SolarFox](#)

![Title](/src/images/titulo.png)

## Working on the project

In order to compile the game you'll need to intall Netbeans. I don't know exactly what plugins are needed so you have to options:
 1. Install Netbeans with all plugins preinstalled (~210Mb)
 2. Install the most basic edition of Netbeans and later from Tools->Plugins install: Java IDE, Java EE, Java SE, Java ME and everything you see with the word "ME" (tools and demo). This should have to work but if you get an error just install the packages the error says to.

Of course, in Tools->Plugins we have to activate every plugin that is installed. Once all plugins are installed and (very important) activated (in Tools->Plugins) you just have to go to Open Project and search the directory were you stored Solarwolf.

## Troubleshooting

Probably you'll get an error the first time you try to run the game in the emulator. To solve this error go to project properties and into the platform tab set the following parameters:

```
Device: DefaultCldcPhone1
Device configuration: CLDC 1.0
Device profile:  MIDP 2.1
```
