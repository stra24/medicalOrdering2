package com.ordering.service;

import com.ordering.entity.Patient;
import com.ordering.repository.PatientMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class PatientService {

  private PatientMapper patientMapper;

  //  連番IDから患者情報を取得
  public Patient findById(Integer showId) {
    return patientMapper.selectById(showId);
  }

  //  重複登録がないかチェックする処理
  public Patient checkNameAndBirthday(Patient patient, Authentication authentication) {
    return patientMapper.selectByNameAndBirthday(patient.getName(), patient.getBirthday());

//    if (nameAndBirthday != null) {
//      String messageAlready = "この患者は登録済みです";
//      return messageAlready;
//    } else {
//      this.save(patient, authentication);
//      String messagePass = "登録が完了しました！";
//      return messagePass;
//    }
  }

  public boolean existPatient(String name, String birthday) {
    return patientMapper.selectByNameAndBirthday(name, birthday) != null;

  }

  //患者の新規作成
  public Patient save(Patient patient, Authentication authentication) {
    boolean existPatient = existPatient(patient.getName(), patient.getBirthday());
    if (existPatient) {
      throw new RuntimeException();
    } else {
      patient.setCreatedBy(authentication.getName());
      patientMapper.insert(patient);
    }

    return findByNameAndBirthday(patient.getName(), patient.getBirthday());
  }

  public Patient findByNameAndBirthday(String name, String birthDay) {
    return patientMapper.selectByNameAndBirthday(name, birthDay);
  }

}
