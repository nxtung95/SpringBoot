package course.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapperService<T, K> {
    private final ModelMapper modelMapper;

    public List<K> mappingTypeObjectList(List<T> sourceObjects, Class<K> destinationType) {
        return sourceObjects.stream()
                .map(object -> modelMapper.map(object, destinationType))
                .collect(Collectors.toList());
    }
}
