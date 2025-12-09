package com.scorpio.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.scorpio.model.Category;
import com.scorpio.service.ReadFileService;

@ExtendWith(MockitoExtension.class)
class CategoryFactoryTest {

    @Mock
    private ReadFileService readFileService;
    @Mock
    private Category category;

    @InjectMocks
    private CategoryFactory factory;

    @Test
    void should_readFileOnlyOnce() {
        // given
        given(readFileService.loadTreeFromResourceFile()).willReturn(category);

        // when
        final var supplier = factory.rootCategorySupplier(readFileService);
        final var category1 = supplier.get();
        final var category2 = supplier.get();

        // then
        assertThat(category1).isEqualTo(category2);
        then(readFileService).should(times(1)).loadTreeFromResourceFile();
    }

}
