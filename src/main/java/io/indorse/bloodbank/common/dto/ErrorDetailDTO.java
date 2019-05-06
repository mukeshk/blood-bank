package io.indorse.bloodbank.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "error")
public class ErrorDetailDTO
{
    private String message;
    private List<String> details;
}
