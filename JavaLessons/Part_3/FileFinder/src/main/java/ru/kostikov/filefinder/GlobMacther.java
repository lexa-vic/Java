package ru.kostikov.filefinder;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 * Created by Алексей on 24.08.2016.
 */
public class GlobMacther implements FindMatcher {

    PathMatcher globMatcher;

    public GlobMacther(String globMask){
        this.globMatcher = FileSystems.getDefault().getPathMatcher("glob:"+globMask);
    }
    @Override
    public boolean compare(String str) {
        return globMatcher.matches(Paths.get(str));
    }
}
