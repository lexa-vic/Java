package ru.kostikov.filefinder;

import com.google.common.base.Joiner;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * Created by Алексей on 24.08.2016.
 * Класс сравнения исходного файла по маске - glob выражения
 */
public class GlobMacther implements FindMatcher {

    private PathMatcher globMatcher;
    private String globMask;

    /**
     * Конструктор
     * @param globMask glob выражение
     */
    public GlobMacther(String globMask){
        this.globMask = globMask;
        this.globMatcher = FileSystems.getDefault().getPathMatcher(Joiner.on("").join("glob:", globMask));
    }
    @Override
    public boolean compare(String str) {
        return globMatcher.matches(Paths.get(str));
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        // obj ссылается на null
        if(obj == null)
            return false;
        // Удостоверимся, что ссылки имеют тот же самый тип
        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            GlobMacther tmp = (GlobMacther)obj;
            if(this.globMask.equals(tmp.globMask))
                return true;
            else
                return false;
        }
    }
}
