/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.transit_data_federation.impl.realtime.history;

import java.util.List;

import org.hibernate.SessionFactory;
import org.onebusaway.gtfs.model.AgencyAndId;
import org.onebusaway.transit_data_federation.services.realtime.ScheduleDeviationHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDeviationHistoryDaoImpl implements
    ScheduleDeviationHistoryDao {

  private HibernateTemplate _template;

  /**
   * Note we are requesting the "mutable" {@link SessionFactory}, aka the one we
   * can write to
   * 
   * @param sessionFactory
   */
  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    _template = new HibernateTemplate(sessionFactory);
  }

  @Override
  public void saveScheduleDeviationHistory(ScheduleDeviationHistory record) {
    _template.save(record);
  }

  @Override
  public void saveScheduleDeviationHistory(
      List<ScheduleDeviationHistory> records) {
    _template.saveOrUpdateAll(records);
  }

  @Override
  public ScheduleDeviationHistory getScheduleDeviationHistoryForTripId(
      AgencyAndId tripId) {
    return _template.get(ScheduleDeviationHistory.class, tripId);
  }
}
