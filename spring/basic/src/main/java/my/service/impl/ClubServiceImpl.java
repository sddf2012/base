package my.service.impl;

import my.service.ClubService;
import org.springframework.stereotype.Service;

/**
 * @author liu peng bo
 * date: 2020/6/2 15:00
 */
@Service
public class ClubServiceImpl implements ClubService {
    @Override
    public String getName() {
        return "football";
    }
}
