package com.design_patterns.abstract_factory.abstractFactory;

import com.design_patterns.abstract_factory.domain.Body;
import com.design_patterns.abstract_factory.domain.Footer;
import com.design_patterns.abstract_factory.domain.Header;

public interface ReportFactory {

    Header createHeader();
    Body createBody();
    Footer createFooter();

}
