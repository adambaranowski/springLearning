package pl.adambaranowski.springvalidationbadwords.constraint.group;

import javax.validation.GroupSequence;

@GroupSequence({Draft.class, Complete.class})
public interface Complete {
}
