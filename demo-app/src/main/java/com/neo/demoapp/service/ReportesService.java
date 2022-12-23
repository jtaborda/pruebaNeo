package com.neo.demoapp.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.neo.demoapp.models.entity.Reportes;

public interface ReportesService {

  Optional<Reportes> findByFechasBetween(Long clientIesd,Date fechaInicio, Date fechaFin);
}
