/*
 * Copyright (c) 2024 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockitousage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Verify (part of) regression https://github.com/mockito/mockito/issues/3294 is fixed.
 */
@ExtendWith(MockitoExtension.class)
class InjectionWithGenericsAndInheritanceIssue3294Test extends BaseTest<String> {

    @Mock Supplier<String> supplier;

    @InjectMocks UnderTest underTest;

    @Test
    void test() {
        assertNotNull(underTest.supplier);
    }
}

class BaseTest<T> {

    @Mock Supplier<T> supplier;
}

class BaseUnderTest<T> {

    Supplier<T> supplier;
}

class UnderTest extends BaseUnderTest<String> {}
