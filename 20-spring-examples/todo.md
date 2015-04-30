# TODO



- exemple de Classe Java de configuration sans @Configuration
  - si possible, quelles en sont les limitations ?
- exemple de MetaAnnotation avec un cas tres complique  (http://www.intertech.com/Blog/spring-4-meta-annotations/)
  @com.zenika.Service
  @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 30, isolation=Isolation.SERIALIZABLE)
  @Scope("request")
  @Profile
  
- Cycle de vie et Lazy initialisation / FactoryBeanPostProcessor / BeanPostProcessor => TODO exemple
- Custom scope / doc Spring () => TODO exemple
- SpEL  (http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#expressions-language-ref)
- Surcharge quand Java config / Annotations / xml => quel est le resultats ? ==> TODO exemple
- exemple : inner bean xml / Java config : 
  faire un inner bean en Java (cet inner bean est-il manage par spring ?)  => TODO exemple
- SpEL : quels sont les mécanismes dans Spring pour évaluer les expressions SpEL ? (BeanFactoryPostProcessor / BeanPostProcessor / Autre ) ==> TODO exemple
- Test : Lancer un test avec @ContextConfiguration sans liste de configuration explicite 
  avec une config java public static class @Configuration xxx{} ET un fichier xml NomCalssText-context.xml
  ==> réponse : l'inner class prime sur le fichier xml ==> TODO exemple
- du coding live avec spring boot (1 repository, 1 controller / 1 page web / 1 service REST) ==> TODO scenario
- Security : différence entre annotations @Secured (ant style) , @PreAuthorized et @PostAuthorized (SpEL style)
  http://www.concretepage.com/spring/spring-security/preauthorize-postauthorize-in-spring-security
  ==> TODO exemple
- Security : si on ajoute 2 fois un filtre aprés le login par ex. est-ce que l'on obtient 2 filtres après ou le 2e ajout écrase le premier. Quel ordre aurons-nous, si 2 ajouts. Ce sera l'ordre d'ajout ?  ==> TODO exemple
- Faire une FAQ ==> TODO
- 