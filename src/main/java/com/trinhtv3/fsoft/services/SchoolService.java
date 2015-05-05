package com.trinhtv3.fsoft.services;

import com.google.inject.Inject;
import com.mongodb.DBObject;
import com.trinhtv3.fsoft.services.base.MongoAbstractCRUD;
import com.trinhtv3.fsoft.services.entity.School;
import com.trinhtv3.fsoft.services.entity.factories.SchoolFactory;
import com.trinhtv3.fsoft.services.utils.DataFactory;


public class SchoolService extends MongoAbstractCRUD<School> {

  private final String col_name = "schools";
  
  @Inject
  private SchoolFactory factory;
  
  public SchoolService(DataFactory mongo) {
    
    this.col = mongo.getDatabase("angularTest").getCollection(col_name);
  
  }
  @Override
  public School transform(DBObject source) {
    School school = factory.create((String) source.get("name"), (String) source.get("address"));
    
    return school;
  }

  
}
