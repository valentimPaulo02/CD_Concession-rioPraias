package frontend.soap;

import frontend.objects.*;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@WebService(targetNamespace = "http://soap.frontend/", endpointInterface = "frontend.soap.SoapServices", portName = "SoapServicesImpPort", serviceName = "SoapServicesImpService")
@Service

public class SoapServicesImp implements SoapServices{

    private List<BeachService> beachServices = new ArrayList<>();

    public SoapServicesImp() {
        // Inicialização de serviços de praia (simulados)
        beachServices.add(new BeachService("A1", 'A', 2));
        beachServices.add(new BeachService("A2", 'A', 2));
        // Adicione mais serviços de praia conforme necessário
    }

    @Override
	public ReturnBeachService GetBeachServices() {
        return new ReturnBeachService("OK", beachServices);
    }

    @Override
	public Message ReserveShadow(Message message) {
        return new Message("OK", "Reserva efetuada com sucesso.");
    }

    @Override
	public Message SendData(Message message) {
        System.out.println("Dados recebidos: " + message.getContent());
        return new Message("OK", "Dados recebidos com sucesso.");
    }
}