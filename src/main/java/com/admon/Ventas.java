package com.admon;
import com.arjuna.common.logging.commonLogger;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/ventas")
public class Ventas {

    private static final Logger log = LoggerFactory.getLogger(Ventas.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String salida() {
        log.info("Entrada 1.1\n");
        return "Salidas metodo get";
    }

}
