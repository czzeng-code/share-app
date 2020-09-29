package ribbonconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zeng
 * @Date 2020/9/25 11:13
 * @Description
 * @Version 1.0
 */
//@Configuration
public class RibbonConfig {
    @Bean
    public IRule iRule(){
        // CTRL+ALT
        return new RandomRule();
    }

}
