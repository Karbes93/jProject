 // Simples Beispiel, wie man den User per Name ausliesst und dann die Standardgruppe hinzufügt. Sauberer waere natuerlich, die Gruppe aus der UserGroup MappingTabelle auszulesen
 
 public User findByUsername(String userName){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from);
        query.where(cb.and(
        cb.equal(from.get("username"), userName)));
        List<User> result = em.createQuery(query).getResultList(); // getResultList() verhindert Nullpointer
        User user = result != null && result.size() == 1 ? result.get(0) : null;
        
        if(user!= null){
            user.addToGroup("app-user"); // Defaultgruppe
        }
        
        return  user;
    }