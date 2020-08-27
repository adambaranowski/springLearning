package pl.adambaranowski.springmvcscopes.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimeComponent {

    //jeżeli będziemy próbować wstrzyknąć obiekt na początku działania
    //aplikacji to nie będzie wtedy żadnej sesji ani żądania
    //więc spring musi utworzyć obiekt proxy
    //w przypadku wstrzykiwania komponentu o krótszym czasie życia
    //do komponentu o dłuższym musimy pamiętać o mechaniźmie proxy
    //proxyMode=ScopedProxyMode.INTERFACES - dla komponentu implementującego jakiś interfejs
    //proxyMode=ScopedProxyMode.TARGET_CLASS dla komponentu bez implementacjio

    private long time;

    public TimeComponent(){
        time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @PostConstruct
    public void afterCreated() {
        System.out.println(this + " created");
    }

    @PreDestroy
    public void beforDestroy() {
        System.out.println(this + " destroyed");
    }
}
