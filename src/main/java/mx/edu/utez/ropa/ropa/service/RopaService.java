package mx.edu.utez.ropa.ropa.service;

import mx.edu.utez.ropa.ropa.model.Ropa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RopaService {

    @Autowired
    IRopaService iRopaService;

    public List<Ropa> listRopa(){
        return iRopaService.findAll();
    }

    public boolean save(Ropa ropa){
        Ropa ropaTemp = iRopaService.saveAndFlush(ropa);
        return true;
    }

    public boolean update(Ropa ropa){
        if(iRopaService.existsById(ropa.getId())){
            iRopaService.saveAndFlush(ropa);
            return true;
        }
        return false;
    }

    public Ropa findById(long id){
        if(iRopaService.existsById(id)){
            Ropa ropaTemp = iRopaService.findById(id);
            return ropaTemp;
        }
        return null;
    }



}
