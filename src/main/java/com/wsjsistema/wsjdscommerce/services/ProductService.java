package com.wsjsistema.wsjdscommerce.services;

import com.wsjsistema.wsjdscommerce.dto.ProductDTO;
import com.wsjsistema.wsjdscommerce.entities.Product;
import com.wsjsistema.wsjdscommerce.repositories.ProductRepository;
import com.wsjsistema.wsjdscommerce.services.execptions.DatabaseException;
import com.wsjsistema.wsjdscommerce.services.execptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    //Buscando Por ID
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id ){
        Product product = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Recurso não encontrado"));
        return  new ProductDTO(product);
    }
//Buscando todos sem ser paginados
//    @Transactional(readOnly = true)
//    public List<ProductDTO>  findAll() {
//        List<Product> result = repository.findAll();
//        return  result.stream().map(x -> new ProductDTO(x)).toList();
//Buscando todos  paginados
@Transactional(readOnly = true)
public Page<ProductDTO> findAll(Pageable pageable) {
    Page<Product> result = repository.findAll(pageable);
    return result.map((x -> new ProductDTO(x)));
}

    @Transactional
    public ProductDTO insert(ProductDTO dto ){
       Product entity = new Product();
       copyDtoToEntity(dto, entity);
       entity = repository.save(entity);
       return  new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto ){
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return  new ProductDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id ){
        try {
            repository.deleteById(id);
        }
        catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }
}
