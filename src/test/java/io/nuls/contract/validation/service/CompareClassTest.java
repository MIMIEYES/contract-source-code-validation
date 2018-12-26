package io.nuls.contract.validation.service;

import io.nuls.contract.vm.OpCode;
import io.nuls.contract.vm.code.ClassCode;
import io.nuls.contract.vm.code.ClassCodeLoader;
import io.nuls.contract.vm.code.MethodCode;
import io.nuls.loadjar.LoadJarTest;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.InsnList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import static org.junit.Assert.*;

public class CompareClassTest {

    @Test
    public void test() {
        InputStream in = null;
        InputStream in1 = null;
        try {
            in = new FileInputStream(LoadJarTest.class.getResource("/contract_local.jar").getFile());
            byte[] contractCode = IOUtils.toByteArray(in);
            in1 = new FileInputStream(LoadJarTest.class.getResource("/contract_7_80.jar").getFile());
            byte[] validateContractCode = IOUtils.toByteArray(in1);

            Assert.assertTrue(CompareJar.compareJarBytes(contractCode, validateContractCode));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in1 != null) {
                try {
                    in1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}