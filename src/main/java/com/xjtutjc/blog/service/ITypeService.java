package com.xjtutjc.blog.service;

import com.xjtutjc.blog.domain.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ITypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id,Type type);

    Type getTypeByName(String name);

    void delete(Long id);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);
}
