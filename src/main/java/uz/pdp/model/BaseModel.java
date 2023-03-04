package uz.pdp.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {
    {
        id=UUID.randomUUID();
        created_date=new Date();
        updated_date=new Date();
    }
    protected UUID id;
    protected Date created_date;
    protected Date updated_date;



}
