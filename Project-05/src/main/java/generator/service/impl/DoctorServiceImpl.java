package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Doctor;
import generator.service.DoctorService;
import generator.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【doctor】的数据库操作Service实现
* @createDate 2023-10-25 12:01:29
*/
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor>
    implements DoctorService{

}




