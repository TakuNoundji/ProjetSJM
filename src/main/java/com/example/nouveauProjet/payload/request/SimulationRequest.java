package com.example.nouveauProjet.payload.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class SimulationRequest {

    private List<SeanceRequest> listeSeance;
}
