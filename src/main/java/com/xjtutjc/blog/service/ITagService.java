package com.xjtutjc.blog.service;

import com.xjtutjc.blog.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITagService {
    Tag saveTag(Tag tag);
    Tag getTag(Long id);


    Page<Tag> listType(Pageable pageable);

    Tag updateType(Long id,Tag tag);

    Tag getTypeByName(String name);

    void delete(Long id);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);
}
