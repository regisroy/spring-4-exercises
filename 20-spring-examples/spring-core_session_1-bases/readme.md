# Partage sur Spring core #1

* Qu'est-ce que Spring ?
* Configurer spring, 3 façons
    - dans des classes java
    - par annotations
    - dans les fichiers des configuration
* Utiliser des propriétés avec spring
    - qu'est-ce qu'une propriété dans spring ?
    - comment récupérer une propriété

## Qu'est-ce que spring ?
* Pourquoi utiliser spring ?
    - pour faire de l'injection de dépendances (code)
    - pour utiliser des classes utilitaires (code)
    - pour vous simplifier la vie (code)
    - pour démarrer votre application plus vite (code)
    
## Le pattern Injection de dépendances
* IOC vs DI
    - exemple: gérer une baraque à frites
        - une baraque à frite
        - le patron
        - george, arthur, Ptolémé, Josiane
        - une cuisine avec de l'huile
        - un comptoir en plastique
        - main: j'ouvre le camion, je démarre ma baraque à frites, j'ouvre
    - Todo list
        - carnet de notes
        - notes
    - La laPoste
        - à l'antiquité : 1 colis, 1 facteur à pied, 1 destination
        - au moyen âge : 1 colis, 1 facteur à cheval, 1 destination
        - à l'ère industrielle : 1 colis, 1 facteur en vélo, 1 destination
        - à l'ère moderne : 1 colis, 1 facteur en voiture, 1 destination
        - dans le futur : 1 colis, 1 facteur véhicule volant, 1 destination
        - dans le futur : 1 colis, 1 drône, 1 destination
        - main : le client arrive à la laPoste, il fait une demande d'envoie d'un colis à envoyer à une destination donnée
            - exemple 1 : 1 classe qui fait tout
            - exemple 2 : plsuieurs classes
            
        