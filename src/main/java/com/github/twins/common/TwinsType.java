package com.github.twins.common;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.impl.util.ClassUtil;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

/**
 * @author mengweijin
 * @date 2022/9/24
 */
@Slf4j
public class TwinsType {
    private static final Set<Class<?>> PRIMITIVE_WRAPPER_TYPES;
    private static final Set<Class<?>> IMMUTABLE_TYPES;

    static {
        Set<Class<?>> tmpPrimitiveWrapperTypes = new HashSet<>();
        tmpPrimitiveWrapperTypes.add(Byte.class);
        tmpPrimitiveWrapperTypes.add(Short.class);
        tmpPrimitiveWrapperTypes.add(Integer.class);
        tmpPrimitiveWrapperTypes.add(Long.class);
        tmpPrimitiveWrapperTypes.add(Boolean.class);
        tmpPrimitiveWrapperTypes.add(Character.class);
        tmpPrimitiveWrapperTypes.add(Float.class);
        tmpPrimitiveWrapperTypes.add(Double.class);
        PRIMITIVE_WRAPPER_TYPES = Collections.unmodifiableSet(tmpPrimitiveWrapperTypes);

        Set<Class<?>> tmpPrimitiveTypes = new HashSet<Class<?>>();
        tmpPrimitiveTypes.add(Byte.TYPE);
        tmpPrimitiveTypes.add(Short.TYPE);
        tmpPrimitiveTypes.add(Integer.TYPE);
        tmpPrimitiveTypes.add(Long.TYPE);
        tmpPrimitiveTypes.add(Boolean.TYPE);
        tmpPrimitiveTypes.add(Character.TYPE);
        tmpPrimitiveTypes.add(Float.TYPE);
        tmpPrimitiveTypes.add(Double.TYPE);

        Set<Class<?>> tmpImmutableJdk6Types = new HashSet<>();
        tmpImmutableJdk6Types.add(String.class);
        tmpImmutableJdk6Types.add(BigDecimal.class);
        tmpImmutableJdk6Types.add(BigInteger.class);
        tmpImmutableJdk6Types.add(UUID.class);
        tmpImmutableJdk6Types.add(URL.class);
        tmpImmutableJdk6Types.add(URI.class);
        tmpImmutableJdk6Types.add(Locale.class);
        tmpImmutableJdk6Types.add(File.class);
        tmpImmutableJdk6Types.add(Inet4Address.class);
        tmpImmutableJdk6Types.add(Inet6Address.class);
        tmpImmutableJdk6Types.add(InetSocketAddress.class);
        tmpImmutableJdk6Types.add(Currency.class);

        Set<Class<?>> tmpImmutableJdk8Types = new HashSet<>();
        // TemporalAccessor
        addClassIfExists(tmpImmutableJdk8Types, "java.time.Instant");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.LocalDate");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.LocalDateTime");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.LocalTime");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.MonthDay");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.OffsetDateTime");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.OffsetTime");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.Year");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.YearMonth");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.ZoneOffset");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.ZonedDateTime");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.chrono.HijrahDate");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.chrono.JapaneseDate");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.chrono.JapaneseEra");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.chrono.MinguoDate");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.chrono.ThaiBuddhistDate");
        // TemporalAmount
        addClassIfExists(tmpImmutableJdk8Types, "java.time.Duration");
        addClassIfExists(tmpImmutableJdk8Types, "java.time.Period");

        Set<Class<?>> tmpImmutableTypes = new HashSet<Class<?>>();
        tmpImmutableTypes.addAll(tmpPrimitiveWrapperTypes);
        tmpImmutableTypes.addAll(tmpPrimitiveTypes);
        tmpImmutableTypes.addAll(tmpImmutableJdk6Types);
        tmpImmutableTypes.addAll(tmpImmutableJdk8Types);
        IMMUTABLE_TYPES = Collections.unmodifiableSet(tmpImmutableTypes);
    }

    public static boolean isPrimitive(final Class<?> cls) {
        return cls != null && cls.isPrimitive();
    }

    public static boolean isPrimitiveWrapper(final Class<?> cls) {
        return cls != null && PRIMITIVE_WRAPPER_TYPES.contains(cls);
    }

    public static boolean isWrapperFor(final Class<?> cls, final Class<?> primitive) {
        return primitive != null && isPrimitiveWrapper(cls) && ClassUtil.getPrimitiveType(cls).equals(primitive);
    }

    public static boolean isPrimitiveFor(final Class<?> cls, final Class<?> wrapper) {
        return wrapper != null && isPrimitive(cls) && ClassUtil.getPrimitiveType(wrapper).equals(cls);
    }

    private static void addClassIfExists(Set<Class<?>> classesContainer, String className) {
        try {
            classesContainer.add(Class.forName(className));
        } catch (ClassNotFoundException exc) {
            log.debug("Class '{}' not found and will be ignored. {}", className, exc.getMessage());
        }
    }
}
