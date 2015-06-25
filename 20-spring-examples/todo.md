# TODO
- exemple de [MetaAnnotation](http://www.intertech.com/Blog/spring-4-meta-annotations) avec un cas tres complique  
  @com.zenika.service.Service
  @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 30, isolation=Isolation.SERIALIZABLE)
  @Scope("request")
  @Profile
- Montrer la documentation Spring
 - Spring framework
 - Spring plateforme
 - Spring security
 - Spring boot
 - Les guides
 - [**SpEL**](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#expressions-language-ref)
- **Custom scope** / doc Spring () => TODO exemple
- Surcharge **quand Java config / Annotations / xml** => quel est le resultats ? ==> TODO exemple
- **inner bean** xml / Java config
  - faire un inner bean en Java (cet inner bean est-il manage par spring ?)  => TODO exemple
- **SpEL :** quels sont les mécanismes dans Spring pour évaluer les expressions SpEL ? (BeanFactoryPostProcessor / BeanPostProcessor / Autre ) ==> TODO exemple
- **Test :** Lancer un test avec @ContextConfiguration sans liste de configuration explicite 
  avec une config java public static class @Configuration xxx{} ET un fichier xml NomCalssText-context.xml
  ==> réponse : l'inner class prime sur le fichier xml ==> TODO exemple
- du coding live avec spring boot (1 repository, 1 controller / 1 page web / 1 service REST) ==> TODO scenario
- **Security :** différence entre annotations @Secured (ant style) , @PreAuthorized et @PostAuthorized (SpEL style)
  http://www.concretepage.com/spring/spring-security/preauthorize-postauthorize-in-spring-security
  ==> TODO exemple
- **Security :** si on ajoute 2 fois un filtre aprés le login par ex. est-ce que l'on obtient 2 filtres après ou le 2e ajout écrase le premier. Quel ordre aurons-nous, si 2 ajouts. Ce sera l'ordre d'ajout ?  ==> TODO exemple
- **Faire une FAQ** ==> TODO
- **JMX** : un server avec une application Hibernate / log4j
 - scenario : 
  - readme d'installation
  - afficher les infos de l'appli
  - modifier la configuration de log4j
- Un serveur ActivMQ avec quelques files : Queue & Topic
- Test spring : appliquer @ActiveProfiles sur Class de test et sur des méthodes de test en même temps => que se passe-t-il ?
- **AOP** : Que se passe t-il quand j'applique plusieurs Advice de type @Around sur le même JoinPoint ?
- **Transaction**  : comment sont traitées traitées les Checked Exceptions ?????? 
- ATTENTION : revoir les expressions poincut dans le détail
- **AOP :** quand pls aspects sur le même bean, combien y a t-il de proxies ?
- Testing : **@Sql** - comment fait-on quand nous avons plusieurs datasources ?
## FAQ
- Data Access Exception : Spring arrive t-il à détecter l'optimistic Locking ou faut-il lancer l'exception **OptimisticLockingFailureException**
 - => Non détecté par la DB elle-même (Géré par le DAO)
- Gestion des exceptions ORM : il est nécessaire de déclarer le BeanPostProcessor

## FAIT
- exemple de Classe Java de configuration sans @Configuration ==> **FAIT : projet spring-examples-weird-java-configuration** 
  - si possible, quelles en sont les limitations ?
- Cycle de vie et Lazy initialisation / FactoryBeanPostProcessor / BeanPostProcessor => **FAIT**

