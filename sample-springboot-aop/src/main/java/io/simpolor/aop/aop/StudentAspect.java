package io.simpolor.aop.aop;

import io.simpolor.aop.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudentAspect {

    /*
    @Pointcut("execution(* io.simpolor.aop.service.StudentService.*(..))")
    public void pointcutStudent(){ }

    @Around("pointcutStudent()")
    */

    @Around("execution(* io.simpolor.aop.service.StudentService.*(..))")
    public Object checkStdent(ProceedingJoinPoint pjp) throws Throwable {

        log.info("Around start - {} / {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());

        Student student = getStudent(pjp);
        if(student != null){
            log.info("student.toString : {}" , student.toString());
        }

        log.info("Around finished - {} / {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());

        return pjp.proceed();
    }

    // @Before("execution(* io.simpolor.aop.service.StudentService.*(..))")
    @After("execution(* io.simpolor.aop.service.StudentService.*(..))")
    public void beforeStudent(JoinPoint joinPoint) {

        log.info("Before/After start - {} / {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

        Student student = getStudent(joinPoint);
        if(student != null){
            log.info("Before student.toString() : {}" , student.toString());
        }

        log.info("Before/After finished - {} / {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* io.simpolor.aop.service.StudentService.*(..))", throwing = "exception")
    public void afterThrowingStudent(JoinPoint joinPoint, Exception exception) {
        log.error("AfterThrowing error message : {}", exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(* io.simpolor.aop.service.StudentService.*(..))", returning = "retVal")
    public void afterReturningStudent(JoinPoint joinPoint, Object retVal) {
        log.info("AfterReturning value : "+retVal.toString());
        if(retVal instanceof Student){
            Student student = (Student) retVal;
            student.setSeq(5);
        }
    }

    private Student getStudent(ProceedingJoinPoint pjp){
        Student student = null;

        Object[] args = pjp.getArgs();
        for(Object o : args){
            if (o instanceof Student){
                student = (Student) o;
                break;
            }
        }
        return student;
    }

    private Student getStudent(JoinPoint joinPoint){
        Student student = null;

        Object[] args = joinPoint.getArgs();
        for(Object o : args){
            if (o instanceof Student){
                student = (Student) o;
                break;
            }
        }
        return student;
    }
}
